package com.mvvm.library.binding.command;

import com.mvvm.library.R;

/**
 * Represents a function with zero arguments.
 *
 * @param <T> the result type
 */
public interface BindingFunction<T> {
    T call();
}
