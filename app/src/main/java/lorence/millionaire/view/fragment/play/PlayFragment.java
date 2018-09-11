package lorence.millionaire.view.fragment.play;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import javax.inject.Inject;

import butterknife.BindView;
import lorence.millionaire.R;
import lorence.millionaire.app.Application;
import lorence.millionaire.di.module.welcome.PlayModule;
import lorence.millionaire.di.module.welcome.WelcomeModule;
import lorence.millionaire.view.activity.welcome.WelcomeActivity;
import lorence.millionaire.view.fragment.BaseFragment;

public class PlayFragment extends BaseFragment implements PlayView {

    @BindView(R.id.animationQuestion)
    LottieAnimationView mAnimationQuestion;

    @BindView(R.id.animationAnswerA)
    LottieAnimationView animationAnswerA;

    @BindView(R.id.animationAnswerB)
    LottieAnimationView animationAnswerB;

    @BindView(R.id.animationAnswerC)
    LottieAnimationView animationAnswerC;

    @BindView(R.id.animationAnswerD)
    LottieAnimationView animationAnswerD;

    @BindView(R.id.tvQuestion)
    TextView tvQuestion;

    private static int TIME_DELAY_QUESTION = 700;


    @Inject
    public PlayFragment() {
    }

    private void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new WelcomeModule((WelcomeActivity) getActivity()))
                .plus(new PlayModule((WelcomeActivity) getActivity() ,this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play, container, false);
        distributedDaggerComponents();
        bindView(view);
        initComponents();
        return view;
    }

    @Override
    public void initComponents() {
    }

    @Override
    public void onResume() {
        super.onResume();
        mAnimationQuestion.setAnimation("question.json");
        mAnimationQuestion.playAnimation();

        animationAnswerA.setAnimation("answer.json");
        animationAnswerA.playAnimation();

        animationAnswerB.setAnimation("answer.json");
        animationAnswerB.playAnimation();

        animationAnswerC.setAnimation("answer.json");
        animationAnswerC.playAnimation();

        animationAnswerD.setAnimation("answer.json");
        animationAnswerD.playAnimation();

        new Handler().postDelayed(loadQuestionMillionaire(), TIME_DELAY_QUESTION);
    }

    private Runnable loadQuestionMillionaire() {
        return new Runnable() {
            @Override
            public void run() {
                tvQuestion.setText(getResources().getString(R.string.dummy_1));
            }
        };
    }
}
