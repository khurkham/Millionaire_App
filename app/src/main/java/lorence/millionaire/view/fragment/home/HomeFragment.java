package lorence.millionaire.view.fragment.home;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.OnClick;
import lorence.millionaire.R;
import lorence.millionaire.app.Application;
import lorence.millionaire.di.module.welcome.HomeModule;
import lorence.millionaire.di.module.welcome.WelcomeModule;
import lorence.millionaire.view.activity.welcome.WelcomeActivity;
import lorence.millionaire.view.fragment.BaseFragment;
import lorence.millionaire.view.fragment.play.PlayFragment;

public class HomeFragment extends BaseFragment implements HomeView {

    @Inject
    PlayFragment mPlayFragment;

    @Inject
    public HomeFragment() {
    }

    private void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new WelcomeModule((WelcomeActivity) getActivity()))
                .plus(new HomeModule((WelcomeActivity) getActivity() ,this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        distributedDaggerComponents();
        bindView(view);
        initComponents();
        return view;
    }

    @Override
    public void initComponents() {
    }

    public interface HomeInterface {
        void interactiveActivity();
    }

    private HomeInterface mInterface;

    @OnClick({R.id.btnPlayGame, R.id.btnHighScore, R.id.btnGuide})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlayGame:
                FragmentManager mFragmentManager = this.getChildFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.add(R.id.fragment_container_frg, mPlayFragment);
                mFragmentTransaction.addToBackStack(mPlayFragment.getTag());
                mFragmentTransaction.commit();
                break;
        }
    }
}
