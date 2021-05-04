package abc.com.bottomnavigation

import abc.com.bottomnavigation.fragments.FavoriteFragment
import abc.com.bottomnavigation.fragments.HomeFragment
import abc.com.bottomnavigation.fragments.SettingFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// create variabele
        val  settingFragment = SettingFragment()
        val homeFragment= HomeFragment()
        val favoriteFragment=FavoriteFragment()
// for current show fragment on activity
        makeCurrentFragment(homeFragment)
        //set up fragments with menu
bottom_navigation.setOnNavigationItemReselectedListener {
    when(it.itemId){
        R.id.home -> makeCurrentFragment(homeFragment)
        R.id.setting -> makeCurrentFragment(settingFragment)
        R.id.favorite -> makeCurrentFragment(favoriteFragment)
    }
    true
}


    }

// setup fragment
    private fun makeCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}