package com.mohammedragab.nutiriationanalysis1.analysisdata
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mohammedragab.nutiriationanalysis1.MainActivity
import com.mohammedragab.nutiriationanalysis1.R
import com.mohammedragab.nutiriationanalysis1.databinding.AddNutritionDataBinding
import com.mohammedragab.nutiriationanalysis1.presentationlayer.AnalysisViewModel
import com.mohammedragab.nutiriationanalysis1.presentationlayer.ViewModelFactory
import com.teraninjas.mazadat.utility.Utile
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 * this fragment  for  add data for analysis  fragment  it have all category for
 *
 */

class AddDataNutritionAnalysisFragment :Fragment() {
    private  val TAG = "AddDataAnalysisFragment"
    lateinit var binding: AddNutritionDataBinding
    lateinit var analysisViewModel: AnalysisViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).analysisComponent.inject(this)
        analysisViewModel = ViewModelProvider(this, viewModelFactory).get(AnalysisViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.add_nutrition_data, container, false)
        binding.lifecycleOwner = this


        binding.button.setOnClickListener {
            val appId=getString(R.string.app_id)
            val appKey=getString(R.string.app_key)
            val nutritionType=getString(R.string.nut_type)
            val ingredient=binding.editIngredient.text.toString()
        if (Utile.isOnline(requireActivity())) {


            analysisViewModel.getSingleLineNutrition(
                appId, appKey, nutritionType, ingredient
            )
        }else{
            Utile.showErrorSnakbar(binding.button,getString(R.string.no_network))
        }

        }
        initObserver()

        binding.editIngredient.addTextChangedListener {
            updateRepoListFromInput()

        }
        return binding.root

    }


    @SuppressLint("RestrictedApi")
    private fun updateRepoListFromInput() {
        binding.editIngredient.text?.trim().let {
            if (it!!.isNotEmpty() && it.length > 8) {

                binding.button.supportBackgroundTintList=
                    ContextCompat.getColorStateList(requireActivity(), R.color.purple_500);
            }else{
                binding.button.supportBackgroundTintList=
                    ContextCompat.getColorStateList(requireActivity(), R.color.gray);

            }
        }
    }
    override fun onStart() {
        super.onStart()
       // homeViewModel.getCategoryAuctionHomeData()

    }

    override fun onDestroy() {
        super.onDestroy() }
    override fun onResume() {
        super.onResume() }

    override fun onPause() {
        super.onPause() }

    fun initObserver(){

        analysisViewModel.loading.observe(viewLifecycleOwner, Observer {

            if (it){
                binding.progressId.progress.visibility=View.VISIBLE
            }else{
                binding.progressId.progress.visibility=View.GONE

            }
        })

        analysisViewModel.responseErrorMessage.observe(viewLifecycleOwner, Observer {

            if (it!=null){

                Utile.showSucesSnakbar(binding.editIngredient,it)
            }else{

            }
        })





    }


}