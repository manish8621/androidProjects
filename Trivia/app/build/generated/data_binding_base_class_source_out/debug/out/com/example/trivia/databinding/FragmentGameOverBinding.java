// Generated by data binding compiler. Do not edit!
package com.example.trivia.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.trivia.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentGameOverBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView questionTv;

  @NonNull
  public final Button tryAgainBtn;

  protected FragmentGameOverBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView imageView, TextView questionTv, Button tryAgainBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView = imageView;
    this.questionTv = questionTv;
    this.tryAgainBtn = tryAgainBtn;
  }

  @NonNull
  public static FragmentGameOverBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_game_over, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentGameOverBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentGameOverBinding>inflateInternal(inflater, R.layout.fragment_game_over, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentGameOverBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_game_over, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentGameOverBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentGameOverBinding>inflateInternal(inflater, R.layout.fragment_game_over, null, false, component);
  }

  public static FragmentGameOverBinding bind(@NonNull View view) {
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
  public static FragmentGameOverBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentGameOverBinding)bind(component, view, R.layout.fragment_game_over);
  }
}