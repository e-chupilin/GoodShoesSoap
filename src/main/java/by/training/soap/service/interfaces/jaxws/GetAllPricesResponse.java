
package by.training.soap.service.interfaces.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import by.training.soap.service.business.bean.ShoesCost;

@XmlRootElement(name = "getAllPricesResponse", namespace = "http://interfaces.service.soap.training.by/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllPricesResponse", namespace = "http://interfaces.service.soap.training.by/")
public class GetAllPricesResponse {

    @XmlElement(name = "return", namespace = "")
    private List<ShoesCost> _return;

    /**
     * 
     * @return
     *     returns List<ShoesCost>
     */
    public List<ShoesCost> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<ShoesCost> _return) {
        this._return = _return;
    }

}
