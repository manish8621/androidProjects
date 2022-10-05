package com.example.rockpaperscissor.databinding;
import com.example.rockpaperscissor.R;
import com.example.rockpaperscissor.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentGameBindingImpl extends FragmentGameBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.player_move_iv, 4);
        sViewsWithIds.put(R.id.computer_move_iv, 5);
        sViewsWithIds.put(R.id.computer_title_tv, 6);
        sViewsWithIds.put(R.id.player_title_tv, 7);
        sViewsWithIds.put(R.id.next_button, 8);
        sViewsWithIds.put(R.id.scissor_btn, 9);
        sViewsWithIds.put(R.id.paper_btn, 10);
        sViewsWithIds.put(R.id.rock_btn, 11);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentGameBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentGameBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.ImageView) bindings[5]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[6]
            , (android.widget.Button) bindings[8]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[9]
            );
        this.computerScoreTv.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.playerScoreTv.setTag(null);
        this.resultTv.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.example.rockpaperscissor.game.GameViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.example.rockpaperscissor.game.GameViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelResult((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelComputerScore((androidx.lifecycle.LiveData<java.lang.Integer>) object, fieldId);
            case 2 :
                return onChangeViewModelPlayerScore((androidx.lifecycle.LiveData<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelResult(androidx.lifecycle.LiveData<java.lang.String> ViewModelResult, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelComputerScore(androidx.lifecycle.LiveData<java.lang.Integer> ViewModelComputerScore, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelPlayerScore(androidx.lifecycle.LiveData<java.lang.Integer> ViewModelPlayerScore, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String viewModelResultGetValue = null;
        androidx.lifecycle.LiveData<java.lang.String> viewModelResult = null;
        androidx.lifecycle.LiveData<java.lang.Integer> viewModelComputerScore = null;
        java.lang.String computerScoreTvAndroidStringScoreViewModelComputerScore = null;
        androidx.lifecycle.LiveData<java.lang.Integer> viewModelPlayerScore = null;
        java.lang.String playerScoreTvAndroidStringScoreViewModelPlayerScore = null;
        java.lang.Integer viewModelPlayerScoreGetValue = null;
        java.lang.Integer viewModelComputerScoreGetValue = null;
        com.example.rockpaperscissor.game.GameViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.result
                        viewModelResult = viewModel.getResult();
                    }
                    updateLiveDataRegistration(0, viewModelResult);


                    if (viewModelResult != null) {
                        // read viewModel.result.getValue()
                        viewModelResultGetValue = viewModelResult.getValue();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.computerScore
                        viewModelComputerScore = viewModel.getComputerScore();
                    }
                    updateLiveDataRegistration(1, viewModelComputerScore);


                    if (viewModelComputerScore != null) {
                        // read viewModel.computerScore.getValue()
                        viewModelComputerScoreGetValue = viewModelComputerScore.getValue();
                    }


                    // read @android:string/score
                    computerScoreTvAndroidStringScoreViewModelComputerScore = computerScoreTv.getResources().getString(R.string.score, viewModelComputerScoreGetValue);
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.playerScore
                        viewModelPlayerScore = viewModel.getPlayerScore();
                    }
                    updateLiveDataRegistration(2, viewModelPlayerScore);


                    if (viewModelPlayerScore != null) {
                        // read viewModel.playerScore.getValue()
                        viewModelPlayerScoreGetValue = viewModelPlayerScore.getValue();
                    }


                    // read @android:string/score
                    playerScoreTvAndroidStringScoreViewModelPlayerScore = playerScoreTv.getResources().getString(R.string.score, viewModelPlayerScoreGetValue);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.computerScoreTv, computerScoreTvAndroidStringScoreViewModelComputerScore);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.playerScoreTv, playerScoreTvAndroidStringScoreViewModelPlayerScore);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.resultTv, viewModelResultGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.result
        flag 1 (0x2L): viewModel.computerScore
        flag 2 (0x3L): viewModel.playerScore
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}