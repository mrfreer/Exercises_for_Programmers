package com.company;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Date;

/**
 * Created by David on 2/4/2017.
 */
public class NotesFirebase {
    public static void main(String[] args) {
        Firebase ref = new Firebase("programming57-99b59.firebaseapp.com");
        ref.setValue(new Date().toString(), new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError fireBaseError,
                                   Firebase firebase) {
                System.out.println(System.currentTimeMillis() + " Done");
            }

        });
    }

}
