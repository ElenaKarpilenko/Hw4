package com.example.hw4
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.hw4.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity(), Parcelable {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: CountViewModel by lazy {
        ViewModelProvider(this)[CountViewModel::class.java]
    }

    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnIncrement.setOnClickListener {
            viewModel.increment()
        }
        binding.btnDecrement.setOnClickListener {
            viewModel.decrement()
        }

        viewModel.counterData.observe(this) { counter ->
            binding.tvCount.text = counter.toString()
        }

        viewModel.toastMessage.observe(this) { message ->
            message?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.textColor.observe(this) { color ->
            binding.tvCount.setTextColor(color)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}