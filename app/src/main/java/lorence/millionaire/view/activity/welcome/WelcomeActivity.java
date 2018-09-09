package lorence.millionaire.view.activity.welcome;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

import com.linroid.filtermenu.library.FilterMenu;
import com.linroid.filtermenu.library.FilterMenuLayout;

import javax.inject.Inject;

import butterknife.BindView;
import lorence.millionaire.R;
import lorence.millionaire.app.Application;
import lorence.millionaire.di.module.welcome.WelcomeModule;
import lorence.millionaire.view.activity.BaseActivity;
import lorence.millionaire.view.fragment.home.HomeFragment;

public class WelcomeActivity extends BaseActivity {

    @Inject
    Context mContext;

    @Inject
    HomeFragment mHomeFragment;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.drawer)
    FrameLayout mDrawer;

    private FilterMenuLayout filterMenu;
    private static int DRAWER_DELAY = 1400;
    private MediaPlayer mPlayer;

    @Override
    public void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new WelcomeModule(this))
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initAttributes() {
        filterMenu = this.findViewById(R.id.filter_menu);
        new FilterMenu.Builder(this)
                .inflate(R.menu.menu_filter)
                .attach(filterMenu)
                .withListener(listener)
                .build();

        FragmentManager mFragmentManager = this.getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.fragment_container, mHomeFragment);
        mFragmentTransaction.disallowAddToBackStack();
        mFragmentTransaction.commit();
    }

    @Override
    protected void initViews() {
//        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        ViewTreeObserver vto = mDrawerLayout.getViewTreeObserver();
        if (vto != null) vto.addOnPreDrawListener(new ShouldShowListener(mDrawerLayout));
    }

    private static class ShouldShowListener implements ViewTreeObserver.OnPreDrawListener {

        private final DrawerLayout drawerLayout;

        private ShouldShowListener(DrawerLayout drawerLayout) {
            this.drawerLayout = drawerLayout;
        }

        @Override
        public boolean onPreDraw() {
            if (drawerLayout != null) {
                ViewTreeObserver vto = drawerLayout.getViewTreeObserver();
                if (vto != null) {
                    vto.removeOnPreDrawListener(this);
                }
            }
            return true;
        }
    }

    FilterMenu.OnMenuChangeListener listener = new FilterMenu.OnMenuChangeListener() {
        @Override
        public void onMenuItemClick(View view, int position) {
        }

        @Override
        public void onMenuCollapse() {

        }

        @Override
        public void onMenuExpand() {

        }
    };

    private void playGame() {
        mPlayer = MediaPlayer.create(this, R.raw.audio);
        mPlayer.start();
        new Handler().postDelayed(openDrawerRunnable(), DRAWER_DELAY);
    }

    private Runnable openDrawerRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                mDrawerLayout.openDrawer(mDrawer);
                new Handler().postDelayed(closeDrawerRunnable(), DRAWER_DELAY);
            }
        };
    }

    private Runnable closeDrawerRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                mDrawerLayout.closeDrawer(mDrawer);
            }
        };
    }

    @Override
    public void onBackPressed() {
        if (mHomeFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
            mHomeFragment.getChildFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}