// Generated by data binding compiler. Do not edit!
package com.example.rockpaperscissor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.rockpaperscissor.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentLastBinding extends ViewDataBinding {
  @NonNull
  public final Button nextButton;

  protected FragmentLastBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button nextButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.nextButton = nextButton;
  }

  @NonNull
  public static FragmentLastBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_last, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentLastBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentLastBinding>inflateInternal(inflater, R.layout.fragment_last, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentLastBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_last, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentLastBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentLastBinding>inflateInternal(inflater, R.layout.fragment_last, null, false, component);
  }

  public static FragmentLastBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentLastBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentLastBinding)bind(component, view, R.layout.fragment_last);
  }
}
