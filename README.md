## Reflection 1
- Melakukan Clean Code <br>
    - Meaningful names : contohnya homePage() yang merupakan function untuk menampilkan Home.html.
    - Function : nama function-nya deskriptif, tidak terdapat side effects.
    - Comments : terdapat beberapa comments yang memperjelas fungsi code terutama di file html dengan css.
    - Error handling : tidak ada return null, terdapat try-catch statement pada ProductRepository.java.
      
- Melakukan Secure Coding <br>
    - mengidentifikasi field input.
    - melakukan validasi data.

- Hal yang dapat di improve <br>
    - melakukan validasi data yang lebih mendetail.
    - untuk id saya memberikan id sebagai angka terurut jika tidak didefinisikan di awal sehingga tidak null isinya.
    - di kemudian hari dapat melakukan otorisasi dan autentikasi.
<br>

## Reflection 2
1. Untuk unit test, saya membuat 3 positif dan 1 negatif unit test baru yang menurut saya cukup baik untuk memverifikasi program, karena cukup cover 2 fitur tambahan yang ada. Untuk memastikan unit test tersebut cukup untuk memverifikasi program adalah dengan melihat setiap function di setiap fitur dan mencari kemungkinan-kemungkinan yang ada. Dengan itu, code coverage semakin naik dan dapat dipastikan setiap aspek kode telah diuji kebenarannya. Meskipun begitu, 100% code coverage tidak berarti kode tersebut terbebas dari bugs atau error. Karena itu semua tetao tergantung dari kualitas test itu sendiri. Test dapat saja telah meng-cover sebuah function, tetapi belum tentu semua kemungkinan dari function itu telah diuji.
2. Menurut saya, cleanliness dari code tersebut akan berkurang karena terdapat perulangan prosedur dan juga instance variables. Selain itu, harus membuat function baru untuk menghitung banyak product dan lain-lainnya. Tentunya, harus ada tambahan pada file html agar dapat dideteksi oleh Functional Test tersebut. Ditambah lagi, belum tentu banyak product dapat merepresentasikan ketepatan output. Itu dikarenakan kemungkinan adanya bug yang menghasilkan jumlah yang tepat namun id, name, atau quantity belum tepat di dalam list. Ditambah lagi, lebih efektif untuk memeriksa id, name, quantity dari produk di list karena telah ada function getProductId() dan kawan-kawan untuk melakukan hal tersebut. 
