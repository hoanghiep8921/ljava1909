package comple.t3h.learnspring;

import org.springframework.context.annotation.Bean;


public class CreateBeanOfGirl {
    @Bean
    public Accessories beanAccessories(){
        return new GucciAccessories();
    }
    @Bean
    public Outfit beanOutfit(){
        return new Bikini();
    }

    @Bean("koreanStyle")
    public HairStyle beanHairStyle(){
        return new KoreanHairStyle();
    }
    @Bean("japanStyle")
    public HairStyle beanJapanStyle(){
        return new JapanHairStyle();
    }
}
