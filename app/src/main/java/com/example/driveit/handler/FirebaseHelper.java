package com.example.driveit.handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.driveit.model.ModelHome;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import java.util.ArrayList;
import java.util.List;

public class FirebaseHelper {

    DatabaseReference db;
    List<ModelHome> cars= new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    //READ
    public List<ModelHome> retrieve()
    {
        db.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                fetchData(snapshot);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                fetchData(snapshot);

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return cars;
    }

    private void fetchData(DataSnapshot dataSnapshot)
    {
        cars.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            String title=ds.getValue(ModelHome.class).getTitle();
            //cars.g
        }
    }

}