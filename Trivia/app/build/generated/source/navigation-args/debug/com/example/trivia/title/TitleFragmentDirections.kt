package com.example.trivia.title

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.trivia.R

public class TitleFragmentDirections private constructor() {
  public companion object {
    public fun actionTitleFragmentToAboutFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_titleFragment_to_aboutFragment)

    public fun actionTitleFragmentToGameFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_titleFragment_to_gameFragment)

    public fun actionTitleFragmentToRulesFragment2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_titleFragment_to_rulesFragment2)
  }
}
