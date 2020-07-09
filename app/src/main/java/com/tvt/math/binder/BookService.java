package com.tvt.math.binder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class BookService extends Service {

    private List<Book> mBookList = new ArrayList<>();

    private IBookManager.Stub mBinder = new IBookManager.Stub() {
        @Override
        public void addBook(Book book) {
            mBookList.add(book);
        }

        @Override
        public void deleteBook(Book book) {
            mBookList.remove(book);
        }

        @Override
        public List<Book> getBooks() {
            return mBookList;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
