import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.kinetichub.tamamall.base.BaseFragment
import com.kinetichub.tamamall.databinding.FragmentLoginBinding
import com.kinetichub.tamamall.navigator.Screens
import com.kinetichub.tamamall.ui.login.LoginViewModel
import com.kinetichub.tamamall.utilities.provideNavigator

class MyCommunityFragment : BaseFragment(){
    private val loginViewModel: LoginViewModel by lazy { ViewModelProvider(this)[LoginViewModel::class.java] }

    private lateinit var fragmentLoginBinding: FragmentLoginBinding

    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        fragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)
        fragmentLoginBinding.viewModel = loginViewModel
        fragmentLoginBinding.lifecycleOwner = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLoginBinding.btnSignIn.setOnClickListener {
            it.provideNavigator().navigateTo(Screens.LOGIN_TO_DASHBOARD, null)
        }
        return fragmentLoginBinding.root

    }
}