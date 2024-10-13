package com.example.yin.model.domin;

import lombok.Data;

import java.io.Serializable;


/*序列化（Serialization）是将对象转换为字节流的过程，以便将其存储到文件、内存中进行传输或在网络中进行传输。
反序列化（Deserialization）则是将字节流转换回对象的过程，以便恢复对象的状态和数据。
目的：在不同的计算机环境或进程之间传递对象，并且保持对象的完整性和一致性。
什么时候使用：1.类的结构进行了增删改查；
           2.跨不同的Java虚拟机（JVM）之间进行序列化和反序列化时
           3.控制类的序列化兼容性
*/

/*
* Lombok的@Data注解:自动生成了所有字段的getter和setter方法，以及equals、hashCode和toString方法。
* 这减少了样板代码，提高了开发效率。*/
@Data
public class Banner implements Serializable {
    private Integer id;
    private String pic;
    //确保在进行序列化和反序列化时，类的版本一致，以避免兼容性问题。类的版本号
    private static final long serialVersionUID = 1L;


    //它首先检查对象引用是否相同（this == that），然后检查是否为空、是否属于同一类，最后比较id和pic字段是否相等
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Banner other = (Banner) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
        return result;
    }

    //Banner对象的字符串表示形式，包括类名、哈希码、id、pic和serialVersionUID,用于调试和日志记录。
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pic=").append(pic);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}
