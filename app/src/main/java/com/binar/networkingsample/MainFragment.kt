package com.binar.networkingsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binar.networkingsample.databinding.FragmentMainBinding
import com.binar.networkingsample.model.GetAllCarResponseItem
import com.binar.networkingsample.network.ApiService
import com.binar.networkingsample.network.CarsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchAllData()
    }

    private fun fetchAllData() {
        CarsApi.retrofitService.allCar()
            .enqueue(object: Callback<List<GetAllCarResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllCarResponseItem>>,
                    response: Response<List<GetAllCarResponseItem>>
                ) {
                    val body = response.body()
                    val code = response.code()
                    if (code == 200) {
                        showList(body)
                        binding.progressBar.visibility = View.GONE
                    } else {
                        binding.progressBar.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
                    binding.progressBar.visibility = View.GONE
                }

            })
    }

    private fun showList(data: List<GetAllCarResponseItem>?) {
        val adapter = MainAdapter(object: MainAdapter.OnClickListener{
            override fun onClickItem(data: GetAllCarResponseItem) {
            }
        })
        adapter.submitData(data)
        binding.recyclerView.adapter = adapter
    }
}