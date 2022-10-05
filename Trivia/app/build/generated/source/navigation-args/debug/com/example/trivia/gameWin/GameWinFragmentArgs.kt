package com.example.trivia.gameWin

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class GameWinFragmentArgs(
  public val totalQuestions: Int,
  public val correctAnswers: Int
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("totalQuestions", this.totalQuestions)
    result.putInt("correctAnswers", this.correctAnswers)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("totalQuestions", this.totalQuestions)
    result.set("correctAnswers", this.correctAnswers)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): GameWinFragmentArgs {
      bundle.setClassLoader(GameWinFragmentArgs::class.java.classLoader)
      val __totalQuestions : Int
      if (bundle.containsKey("totalQuestions")) {
        __totalQuestions = bundle.getInt("totalQuestions")
      } else {
        throw IllegalArgumentException("Required argument \"totalQuestions\" is missing and does not have an android:defaultValue")
      }
      val __correctAnswers : Int
      if (bundle.containsKey("correctAnswers")) {
        __correctAnswers = bundle.getInt("correctAnswers")
      } else {
        throw IllegalArgumentException("Required argument \"correctAnswers\" is missing and does not have an android:defaultValue")
      }
      return GameWinFragmentArgs(__totalQuestions, __correctAnswers)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): GameWinFragmentArgs {
      val __totalQuestions : Int?
      if (savedStateHandle.contains("totalQuestions")) {
        __totalQuestions = savedStateHandle["totalQuestions"]
        if (__totalQuestions == null) {
          throw IllegalArgumentException("Argument \"totalQuestions\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"totalQuestions\" is missing and does not have an android:defaultValue")
      }
      val __correctAnswers : Int?
      if (savedStateHandle.contains("correctAnswers")) {
        __correctAnswers = savedStateHandle["correctAnswers"]
        if (__correctAnswers == null) {
          throw IllegalArgumentException("Argument \"correctAnswers\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"correctAnswers\" is missing and does not have an android:defaultValue")
      }
      return GameWinFragmentArgs(__totalQuestions, __correctAnswers)
    }
  }
}
