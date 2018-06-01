package e.wilso.fragmentlifecycle;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SwapActivity extends AppCompatActivity {

   private FragmentManager fragManager;
   private ContactFragment contact;
   private DetailFragment detail;
   private boolean change = true;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_swap);

      contact = ContactFragment.newInstance("a", "b");
      detail = DetailFragment.newInstance("a", "b");
      fragManager = getSupportFragmentManager();

      android.support.v4.app.FragmentTransaction trans = fragManager.beginTransaction();
      trans.add(R.id.container, contact);
      trans.commit();

      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      fab.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            swap();
         }
      });
   }

   private void swap() {

      if(change) {
         change = false;
         android.support.v4.app.FragmentTransaction trans = fragManager.beginTransaction();
         trans.replace(R.id.container, detail);
         trans.addToBackStack(null);
         trans.commit();
      }
      else {
         change = true;
         android.support.v4.app.FragmentTransaction trans = fragManager.beginTransaction();
         trans.replace(R.id.container, contact);
         trans.addToBackStack(null);
         trans.commit();
      }
   }
}
