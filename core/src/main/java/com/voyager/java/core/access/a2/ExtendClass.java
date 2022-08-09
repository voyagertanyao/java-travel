package com.voyager.java.core.access.a2;

import com.voyager.java.core.access.a1.BaseClass;


/**
 * access privilege
 * public > protected > package access (default) > private
 */
public class ExtendClass extends BaseClass {

    public void func(){
        pub();
        prot();
    }

}
