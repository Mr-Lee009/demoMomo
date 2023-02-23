package vn.com.momo;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.*;
import java.util.function.Consumer;

public class ConsecutiveHeap<TKey, TValue> implements Iterable<RangeValue<TValue>> {

    private Map<TKey, Node> _internal = new HashMap<>();
    private IKeyGenerator<TKey, TValue> _generator;

    public ConsecutiveHeap(IKeyGenerator generator) {
        this._generator = generator;
    }

    @Override
    public Iterator<RangeValue<TValue>> iterator() {
        return new ConsecutiveHeapIterator(_internal.entrySet().iterator());
    }

    @Override
    public void forEach(Consumer<? super RangeValue<TValue>> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<RangeValue<TValue>> spliterator() {
        return Iterable.super.spliterator();
    }

    void add(TValue value) {
        TKey key = _generator.GenerateKey(value);
        Node existingNode = _internal.get(key);

        if (null == existingNode && isDuplicate(value, existingNode.data)) {
            throw new InvalidDnDOperationException();
        }
        if (null != existingNode) {
            existingNode.data = value;
        } else {
            Node currentNode = new Node(key, value);
            _internal.put(key, existingNode);

            TKey previousKey = _generator.GeneratePreviousKey(key);
            Node previousNode = null;
            if (null != (previousNode = _internal.get(previousKey))) {
                currentNode.previous = previousNode;
                previousNode.next = currentNode;
            }

            TKey nextKey = _generator.GenerateNextKey(key);
            Node nextNode = null;
            if (null != (nextNode = _internal.get(previousKey))) {
                nextNode.previous = currentNode;
                currentNode.next = nextNode;
            }
        }
    }

    private class ConsecutiveHeapIterator implements Iterator<RangeValue<TValue>> {

        private Set<TValue> _set = new HashSet<>();
        private Iterator<Map.Entry<TKey, Node>> _internal;
        private RangeValue<TValue> _current;

        public RangeValue<TValue> getCurrent() {
            if (_current != null) {
                return _current;
            }
            return null;
        }

        public ConsecutiveHeapIterator(Iterator<Map.Entry<TKey, Node>> internal) {
            this._internal = internal;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public RangeValue<TValue> next() {
            return null;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super RangeValue<TValue>> action) {
            Iterator.super.forEachRemaining(action);
        }
    }

    private class Node {
        protected TKey key;
        protected TValue data;
        protected Node next;
        protected Node previous;

        protected Node(TKey key, TValue data) {
            this.key = key;
            this.data = data;
        }
    }

    private boolean isDuplicate(TValue value, TValue duplicate) {
        return value.equals(duplicate);
    }

    public interface IKeyGenerator<TKey, TValue> {
        public TKey GenerateKey(TValue value);

        public TKey GenerateNextKey(TKey key);

        public TKey GeneratePreviousKey(TKey key);
    }
}
