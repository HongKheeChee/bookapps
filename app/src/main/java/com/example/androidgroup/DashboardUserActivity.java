package com.example.androidgroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.androidgroup.databinding.ActivityDashboardUserBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DashboardUserActivity extends AppCompatActivity {

    //to show in tabs
    public ArrayList<com.example.androidgroup.ModelCategory> categoryArrayList;
    public ViewPagerAdapter viewPagerAdapter;

    private ActivityDashboardUserBinding binding;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth=FirebaseAuth.getInstance();
        checkUser();

        setupViewPageAdapter(binding.viewPager);
        binding.tabLayout.setupWithViewPager(binding.viewPager);

        //handle click,logout
        binding.logoutBtn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               firebaseAuth.signOut();
               checkUser();

           }
        });

    }

    private void  setupViewPageAdapter(ViewPager viewPager){
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,this);

        categoryArrayList=new ArrayList<>();

        //load categories from firebase
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Categories");
        ref.addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot snapshot){
                //clear before adding to list
                categoryArrayList.clear();

                /*load categories - static e.g. All*/
                //Add data to models
                com.example.androidgroup.ModelCategory modelAll = new com.example.androidgroup.ModelCategory("81","All","",1);
                com.example.androidgroup.ModelCategory modelMostViewed = new com.example.androidgroup.ModelCategory("82","Most Viewed","",1);
                com.example.androidgroup.ModelCategory modelMostDownloaded= new com.example.androidgroup.ModelCategory("83","most Downloaded","",1);
                //add models to list
                categoryArrayList.add(modelAll);
                categoryArrayList.add(modelMostViewed);
                categoryArrayList.add(modelMostDownloaded);
                //add data to view page adapter
                viewPagerAdapter.addFragment(BooksUserFragment.newInstance(
                        ""+modelAll.getId(),
                        ""+modelAll.getCategory(),
                        ""+modelAll.getUid()
                ),modelAll.getCategory());
                viewPagerAdapter.addFragment(BooksUserFragment.newInstance(
                        ""+modelMostViewed.getId(),
                        ""+modelMostViewed.getCategory(),
                        ""+modelMostViewed.getUid()
                ),modelMostViewed.getCategory());
                viewPagerAdapter.addFragment(BooksUserFragment.newInstance(
                        ""+modelMostDownloaded.getId(),
                        ""+modelMostDownloaded.getCategory(),
                        ""+modelMostDownloaded.getUid()
                ),modelMostDownloaded.getCategory());
                //refresh list
                viewPagerAdapter.notifyDataSetChanged();

                //now load from firebase
                for(DataSnapshot ds: snapshot.getChildren()){
                    //get data
                    com.example.androidgroup.ModelCategory model= ds.getValue(com.example.androidgroup.ModelCategory.class);
                    //add data to the list
                    categoryArrayList.add(model);
                    //add data to viewPageAdapter
                    viewPagerAdapter.addFragment(BooksUserFragment.newInstance(
                            ""+model.getId(),
                            ""+model.getCategory(),
                            ""+model.getUid()), model.getCategory());
                    //refresh list
                    viewPagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError error){

            }
        });

        //set adapter to view pager
        viewPager.setAdapter(viewPagerAdapter);

    }

    public class ViewPagerAdapter extends FragmentPagerAdapter{


        private ArrayList<BooksUserFragment> fragmentList= new ArrayList<>();
        private ArrayList<String> fragmentTitleList= new ArrayList<>();
        private Context context;

        public ViewPagerAdapter( FragmentManager fm, int behavior, Context context) {
            super(fm, behavior);
            this.context=context;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        private  void addFragment(BooksUserFragment fragment,String title){
            //add fragment passed as parameter in fragmentlist
            fragmentList.add(fragment);
            //add title passed as parameter in fragmentlist
            fragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position){
            return fragmentTitleList.get(position);
        }
    }


    private void checkUser(){
        //get current user
        FirebaseUser firebaseUser= firebaseAuth.getCurrentUser();
        if(firebaseUser==null){
            //not logged in
            startActivity(new Intent(this, com.example.androidgroup.LoginActivity.class));
            finish();
        }
        else{
            //logged
            String email= firebaseUser.getEmail();
            //set in textview of toolbar
            binding.subTitleTv.setText(email);
        }
    }
}