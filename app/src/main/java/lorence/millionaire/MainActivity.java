package lorence.millionaire;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.linroid.filtermenu.library.FilterMenu;
import com.linroid.filtermenu.library.FilterMenuLayout;

public class MainActivity extends AppCompatActivity {

    FilterMenuLayout filterMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filterMenu = this.findViewById(R.id.filter_menu);
        new FilterMenu.Builder(this)
                .inflate(R.menu.menu_filter)
                .attach(filterMenu)
                .withListener(listener)
                .build();
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
}

/**
 * Debug Log: https://github.com/JakeWharton/hugo
 */