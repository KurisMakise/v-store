package store.remoteController;

 import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author violet
 * @version 1.0
 * @since 2019/4/18 10:38
 */
 public interface IHello {
    String hello(@RequestParam("name") String name);
}
