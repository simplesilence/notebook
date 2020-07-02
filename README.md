
# material文件夹存放项目中需要的jar包

    需手动打入本地maven仓库
    
        algs4-1.0.0.0.jar 是源码编译包
        mvn install:install-file -Dfile=D:\learning_materials\algorithm\algs4\target\algs4-1.0.0.0.jar -DgroupId=edu.princeton.cs -DartifactId=algs4 -Dversion=1.0.0.0 -Dpackaging=jar
        
        algs4-1.0.0.0-sources.jar 是源码包
        mvn install:install-file -Dfile=D:\learning_materials\algorithm\algs4\target\algs4-1.0.0.0-sources.jar -DgroupId=edu.princeton.cs -DartifactId=algs4 -Dversion=1.0.0.0 -Dpackaging=jar -Dclassifier=sources