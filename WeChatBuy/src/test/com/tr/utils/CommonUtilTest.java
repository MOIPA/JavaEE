package test.com.tr.utils; 

import com.tr.utils.CommonUtil;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* CommonUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>五月 2, 2018</pre> 
* @version 1.0 
*/ 
public class CommonUtilTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}

    /**
     * Method: splitUrl(String parseString)
     */
    @Test
    public void testSplitUrl() throws Exception {
        String testString = "PicUrl:||a/123.jpg||b/234.jpg||c.jpg";
        List<String> list = CommonUtil.splitUrl(testString);

    }


} 
