# Survivor Bird

Survivor Bird, Android için geliştirilen bir 2D arcade oyunudur. Oyunda bir kuşu kontrol ederek engellerden kaçmanız ve mümkün olduğunca yüksek puan elde etmeniz gerekmektedir. Oyun, libGDX framework'ü ile Java kullanılarak geliştirilmiştir.

## Özellikler
- Basit ve eğlenceli oyun mekaniği
- Dokunmatik ekran ile kontrol
- Skor sistemi
- Farklı arı engelleri
- Oyun bitince tekrar başlatma

## Kurulum

### Gereksinimler
- Java 8+
- Android Studio
- Android SDK (minSdkVersion: 19, targetSdkVersion: 35)

### Derleme ve Çalıştırma
1. Depoyu klonlayın veya indirin.
2. Android Studio ile açın.
3. Gerekli SDK ve bağımlılıkların kurulu olduğundan emin olun.
4. Bir Android cihaz veya emülatörde çalıştırın.

## Proje Yapısı
- `core/`: Oyunun ana mantığı ve libGDX kodları
- `android/`: Android platformuna özel dosyalar ve başlatıcı
- `assets/`: Oyun görselleri (background.png, bird.png, bee.png)

## Kullanılan Kütüphaneler
- [libGDX](https://libgdx.com/) (v1.12.1)
- Android Gradle Plugin

## Oyun Nasıl Oynanır?
- Ekrana dokunarak kuşu yukarı zıplatın.
- Arılardan kaçın ve puan kazanın.
- Kuş yere veya bir engele çarparsa oyun biter.
- "Game Over" ekranında tekrar dokunarak yeniden başlayabilirsiniz.

## Katkı
Katkıda bulunmak için pull request gönderebilirsiniz.

## Lisans
Bu proje kişisel kullanım içindir.

