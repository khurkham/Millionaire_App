package lorence.millionaire.view.fragment.guide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import lorence.millionaire.R;
import lorence.millionaire.view.fragment.BaseFragment;

public class GuideFragment extends BaseFragment implements GuideView {

    @BindView(R.id.animationView)
    LottieAnimationView mAnimationView;

    public GuideFragment() {
    }

    private void distributedDaggerComponents() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);
        distributedDaggerComponents();
        bindView(view);
        initComponents();
        return view;
    }

    @Override
    public void initComponents() {
        mAnimationView.setAnimation("default.json");
        mAnimationView.playAnimation();
    }
}
