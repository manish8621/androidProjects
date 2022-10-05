// Generated by data binding compiler. Do not edit!
package com.example.rockpaperscissor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.rockpaperscissor.R;
import com.example.rockpaperscissor.game.GameViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentGameBinding extends ViewDataBinding {
  @NonNull
  public final ImageView computerMoveIv;

  @NonNull
  public final TextView computerScoreTv;

  @NonNull
  public final TextView computerTitleTv;

  @NonNull
  public final Button nextButton;

  @NonNull
  public final ImageView paperBtn;

  @NonNull
  public final ImageView playerMoveIv;

  @NonNull
  public final TextView playerScoreTv;

  @NonNull
  public final TextView playerTitleTv;

  @NonNull
  public final TextView resultTv;

  @NonNull
  public final ImageView rockBtn;

  @NonNull
  public final ImageView scissorBtn;

  @Bindable
  protected GameViewModel mViewModel;

  protected FragmentGameBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView computerMoveIv, TextView computerScoreTv, TextView computerTitleTv,
      Button nextButton, ImageView paperBtn, ImageView playerMoveIv, TextView playerScoreTv,
      TextView playerTitleTv, TextView resultTv, ImageView rockBtn, ImageView scissorBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.computerMoveIv = computerMoveIv;
    this.computerScoreTv = computerScoreTv;
    this.computerTitleTv = computerTitleTv;
    this.nextButton = nextButton;
    this.paperBtn = paperBtn;
    this.playerMoveIv = playerMoveIv;
    this.playerScoreTv = playerScoreTv;
    this.playerTitleTv = playerTitleTv;
    this.resultTv = resultTv;
    this.rockBtn = rockBtn;
    this.scissorBtn = scissorBtn;
  }

  public abstract void setViewModel(@Nullable GameViewModel viewModel);

  @Nullable
  public GameViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static FragmentGameBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_game, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentGameBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentGameBinding>inflateInternal(inflater, R.layout.fragment_game, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentGameBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_game, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentGameBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentGameBinding>inflateInternal(inflater, R.layout.fragment_game, null, false, component);
  }

  public static FragmentGameBinding bind(@NonNull View view) {
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
  public static FragmentGameBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentGameBinding)bind(component, view, R.layout.fragment_game);
  }
}