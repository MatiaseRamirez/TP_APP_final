package mylogin.com

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import mylogin.com.fragments.CardFragment
import mylogin.com.fragments.AddresFragment
import mylogin.com.fragments.ClaimsFragment
import mylogin.com.fragments.PhoneFragment
import mylogin.com.fragments.MenuFragment
import com.google.android.material.navigation.NavigationView
import mylogin.com.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar=binding.toolbarHome
        setSupportActionBar(toolbar)

        drawerLayout =binding.drawerLayout
        toggle=ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_drawer_home_open,R.string.nav_drawer_home_close)
        drawerLayout.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    // MenuFragment por defecto al iniciar la aplicación en el metodo OnCreate

        val navigationView = binding.navigationViewHome
        navigationView.setNavigationItemSelectedListener(this)
        replaceFragment(MenuFragment())


    //Recibe la variable enviada desde el MainActivity
        val username=intent.getStringExtra("username")
        val headerView = navigationView.getHeaderView(0)
        val textViewHeader: TextView = headerView.findViewById(R.id.tvNameNavigationHeader)
        textViewHeader.text=username

    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_item_cards -> {
                replaceFragment(CardFragment())
            }

            R.id.nav_item_addres -> {
                replaceFragment(AddresFragment())
            }

            R.id.nav_item_phone -> {
                replaceFragment(PhoneFragment())
            }
            /*R.id.nav_item_favorites -> {
                replaceFragment(FavoritesFragment())
            }*/
            R.id.nav_item_claims -> {
                replaceFragment(ClaimsFragment())
            }

            R.id.nav_item_menu -> {
                replaceFragment(MenuFragment())
            }

            R.id.nav_item_singoff -> {
                Toast.makeText(this, "Cerrando Session", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }

}
