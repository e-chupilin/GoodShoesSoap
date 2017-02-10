
package by.training.soap.service.interfaces.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import by.training.soap.service.business.bean.ShoesCost;

@XmlRootElement(name = "setShoesPrice", namespace = "http://interfaces.service.soap.training.by/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setShoesPrice", namespace = "http://interfaces.service.soap.training.by/")
public class SetShoesPrice {

    @XmlElement(name = "arg0", namespace = "")
    private ShoesCost arg0;

    /**
     * 
     * @return
     *     returns ShoesCost
     */
    public ShoesCost getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(ShoesCost arg0) {
        this.arg0 = arg0;
    }

}
