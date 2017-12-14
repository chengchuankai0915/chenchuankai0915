package fourteam.cck.com.fourteam.cck.presenter;

import fourteam.cck.com.fourteam.bean.ChoicenessBean;
import fourteam.cck.com.fourteam.cck.model.ChoicenessModelImpl;
import fourteam.cck.com.fourteam.cck.view.ChoicenessView;

/**
 * Created by C-PC on 2017/12/14.
 */

public class ChoicenessPresenterImpl implements ChoicenessPresenter{
    ChoicenessView choicenessView;
    private final ChoicenessModelImpl choicenessModel;

    public ChoicenessPresenterImpl(ChoicenessView choicenessView) {
        this.choicenessView = choicenessView;
        choicenessModel = new ChoicenessModelImpl(this);
    }

    @Override
    public void guanlian() {
        choicenessModel.getData();
    }

    @Override
    public void OngetData(ChoicenessBean choicenessBean) {
        choicenessView.showData(choicenessBean);
    }
}
