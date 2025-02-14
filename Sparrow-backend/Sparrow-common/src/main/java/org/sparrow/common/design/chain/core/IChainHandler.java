package org.sparrow.common.design.chain.core;

public interface IChainHandler<T> {
    Boolean execute(T component);
}
