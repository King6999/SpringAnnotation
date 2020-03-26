package jx.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"jx.bean.Blue"};//这里需要注意写的是类的全路径名
    }
}
