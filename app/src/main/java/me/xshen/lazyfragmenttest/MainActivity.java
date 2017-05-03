package me.xshen.lazyfragmenttest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_shopping_cart:
                    mViewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mViewPager = (ViewPager) findViewById(R.id.content_paper);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return OriginFragment.newInstance("OriginFragment", position);
                    case 1:
                        return InheritedLazyFragment.newInstance("InheritedLazyFragment", position);
                    case 2:
                        Bundle bundle = new Bundle();
                        bundle.putString(InheritedLazyFragment.FRAGMENT_MSG, "ProxyLazyFragment");
                        bundle.putInt(InheritedLazyFragment.FRAGMENT_POS, position);
                        return ProxyFakeFragment.newInstance(OriginFragment.class.getName(), bundle);
                    case 3:
                    default:
                        return OriginFragment.newInstance("OriginFragment", position);
                }
            }

            @Override
            public int getCount() {
                return navigation.getMenu().size();
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigation.setSelectedItemId(navigation.getMenu().getItem(position).getItemId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
