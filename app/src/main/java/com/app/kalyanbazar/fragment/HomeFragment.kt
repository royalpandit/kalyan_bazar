package com.app.kalyanbazar.fragment


import androidx.recyclerview.widget.LinearLayoutManager
import com.app.kalyanbazar.R
import com.app.kalyanbazar.adapter.AdapterHome
import com.app.kalyanbazar.databinding.FragmentHomeBinding
import com.app.kalyanbazar.model.User
import com.app.kalyanbazar.utils.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    val users = ArrayList<User>()
    override fun setupViews() {
        dataBinding.apply {
            // contTop.ivBack.visibility = View.GONE
            setAdapter()
        }

    }

    override fun setupViewsOnResume() {
     }
//fragment_home
    override fun getLayoutId(): Int =R.layout.fragment_home

    fun setAdapter(){
       // dataBinding.recRecyclerView.layoutManager = LinearLayoutManager(requireActivity(), LinearLayout.VERTICAL, false)


        //crating an arraylist to store users using the data class user


        //adding some dummy data to the list
        users.add(User("Welcome Bnous", "2023-06-01 10:20:09","Milan Morning","10:20 AM","12:20 PM","220-47-223"))
        users.add(User("New Bonus", "2023-06-03 10:20:09","Rudrakh Morning","10:20 AM","12:20 PM","120-47-253"))
        users.add(User("Joining Bonus", "2023-06-08 10:20:09","Kalyan Morning","10:20 AM","12:20 PM","820-47-223"))
        users.add(User("Logout Bonus Also", "2023-06-12 10:20:09","Madhur Morning","10:20 AM","12:20 PM","720-47-423"))
        users.add(User("Refer Bonus Also", "2023-06-12 10:20:09","Sapna Morning","10:20 AM","12:20 PM","720-47-423"))
        users.add(User("Double Bonus Also", "2023-06-12 10:20:09","Double Morning","10:20 AM","12:20 PM","720-47-423"))
        users.add(User("Iphone Bonus Also", "2023-06-12 10:20:09","Iphone Morning","10:20 AM","12:20 PM","720-47-423"))
        users.add(User("Small Bonus Also", "2023-06-12 10:20:09","Small Morning","10:20 AM","12:20 PM","720-47-423"))
        users.add(User("Big Bonus Also", "2023-06-12 10:20:09","Big Morning","10:20 AM","12:20 PM","720-47-423"))
        users.add(User("Triple Bonus Also", "2023-06-12 10:20:09","Triple Morning","10:20 AM","12:20 PM","720-47-423"))

        //creating our adapter

        val adapter = AdapterHome(requireActivity(), users)
        dataBinding.recRecyclerView.setHasFixedSize(true)
        dataBinding.recRecyclerView.adapter = adapter
        dataBinding.recRecyclerView.layoutManager = LinearLayoutManager(requireActivity())


    }
}