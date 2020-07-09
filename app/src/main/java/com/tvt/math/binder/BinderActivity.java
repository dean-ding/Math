package com.tvt.math.binder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.FrameworkRouterUrl;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

@Route(path = FrameworkRouterUrl.BinderAct)
public class BinderActivity extends AppCompatActivity {

    private IBookManager mBookManager;

    private AppCompatTextView addBook, delBook, getBooks;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.binder_act);
        init();
        initListener();
    }

    private void init() {
        addBook = findViewById(R.id.tvAddBook);
        delBook = findViewById(R.id.tvDelBook);
        getBooks = findViewById(R.id.tvGetBook);

        Intent intent = new Intent(this, BookService.class);
//        intent.setAction("com.tvt.math.service");
//        intent.setPackage("com.tvt.math.binder");
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private void initListener() {
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mBookManager.addBook(new Book("1"));
                }
                catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        delBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mBookManager.deleteBook(new Book("1"));
                }
                catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        getBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    List<Book> books = mBookManager.getBooks();
                    Log.d(getClass().getSimpleName(), books.toString());
                }
                catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBookManager = IBookManager.Stub.asInterface(service);
            try {
                mBookManager.addBook(new Book("100"));
                mBookManager.addBook(new Book("101"));
                mBookManager.addBook(new Book("102"));
                mBookManager.addBook(new Book("103"));
            }
            catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
    }
}
