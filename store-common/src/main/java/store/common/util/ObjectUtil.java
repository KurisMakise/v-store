package store.common.util;
//
//import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;

/**
 * <p>
 * 序列化对象
 * </p>
 *
 * @author violet
 * @version 1.0
 * @since 2019/4/17 9:40
 */
public class ObjectUtil {

//
//    /**
//     * @param object 序列化对象
//     * @return 序列化结果
//     */
//    public static byte[] object2Bytes(Object object) {
//        try (ByteOutputStream byteOutputStream = new ByteOutputStream(); ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream)) {
//            objectOutputStream.writeObject(object);
//            return byteOutputStream.getBytes();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * @param bytes 反序列化对象
//     * @return 生成对象
//     */
//    public static Object bytes2Object(byte[] bytes) {
//        try (ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes); ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream)) {
//            return objectInputStream.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
