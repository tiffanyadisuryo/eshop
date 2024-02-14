# Tutorial 1
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

# Tutorial 2

Link Home page : https://eshop-tiffanyadisuryo.koyeb.app/



## Reflection 1
1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.
   - Terdapat beberapa import yang tidak diperlukan. Issue tersebut kemudian diatasi dengan cara di hapus.
   - Terdapat beberapa line yang tidak terdeteksi bila terjadi kesalahan seperti contoh pada edit dan delete yang jika product yang dilakukan aksi tidak ditemukan, maka tidak terdeteksi. Solusinya menambah throws exception dan juga menambah test untuk memastikan hal tersebut.
   - Terdapat code yang duplikat pada file html. Solusinya adalah menghapus salah satu code tersebut.

2. Menurut saya, sudah lumayan bisa dibilang continuous integration dan continuous deployment. Definisi dari continuous integration adalah praktik pengembangan perangkat lunak di mana perubahan & pembaruan berkelanjutan dalam basis kode diintegrasikan dan diverifikasi oleh skrip pembuatan otomatis menggunakan berbagai alat. Dalam workflow CI, kode yang diperbarui saat push akan secara otomatis diperiksa dan diverifikasi. Sementara untuk continuous deployment yang berdefinisi praktik pengembangan perangkat lunak di mana perubahan & pembaruan berkelanjutan dalam basis kode akan melalui proses deployment pada sebuah folder aplikasi secara otomatis. Dengan menggunakan Koyeb, setiap pembaruan push, akan langsung deploy dan menampilkan perubahan pada web aplikasi. Dengan itu, saya bisa bilang saya sudah mengimplementasikan kedua hal tersebut.

