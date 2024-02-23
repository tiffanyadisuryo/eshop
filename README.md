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


# Tutorial 3

## Reflection 1
1) Explain what principles you apply to your project!
   1. Single Responsibility Principle (SRP) menyatakan bahwa sebuah class harus berfokus pada satu responsibility agar lebih mudah di-maintain. Saya telah mengaplikasikan ini pada kode saya sehingga tidak ada kelas yang melenceng dari fokus. Selain itu saya membuat method findById yang sebelumnya tidak ada sehingga function edit dan delete sekarang tidak perlu melakukan for loop, melainkan tinggal menggunakan function findById.
   2. Open/Closed Principle (OCP) menyatakan bahwa class, modul, function, etc harusnya terbuka untuk extension namun tidak perlu memodifikasi source code. Ini sudah saya aplikasikan salah satunya dengan CarService (interface) dan CarServiceImpl, sehingga perubahan yang diperlukan dapat dilakukan di CarServiceImpl sehingga tidak mengubah interface. Berlaku hal yang sama pada ProductService dan ProductServiceImpl.
   3. Liskov Substitution Principle (LSP) menyatakan bahwa object pada superclass bersifat replacable dengan objects pada subclass-nya tanpa memengaruhi kebenaran program. Ini telah diaplikasikan pada pemisahan class CarController dari ProductController. Jika sebelumnya CarController extends ProductController, saya hapus karena fungsi-fungsi di dalamnya tidak saling replacable karena Product dan Car berbeda. 
   4. Interface Segregation (ISP) menyatakan bahwa interface seharusnya spesifik pada keperluan. Ini diaplikasikan pada CarService dan ProductService yang merupakan interface yang dipisah dan berfokus pada object-nya masing-masing.
   5. Dependency Inversion Principle (DIP) menyatakan bahwa modul atau class yang high-level tidak seharusnya bergantung pada low-level modul atau class. Ini saya implementasikan pada CarController yang awalnya dependen dengan CarServiceImpl yaitu sebuah concrete class, saya ganti menjadi pada CarService yaitu sebuah interface. Ini dilakukan agar coupling antar modul lebih longgar.
2) Explain the advantages of applying SOLID principles to your project with examples.
    - Kode menjadi lebih mudah dibaca dan di-maintain karena SRP setiap class terfokus pada tujuannya masing-masing menjadi method kecil-kecil simple yang melakukan sesuatu yang kompleks.
    - Kode jadi lebih fleksible dan dapat dikembangkan tanpa mengganti source code terlalu banyak.
    - Testing juga jadi lebih mudah karena setiap function memiliki tujuan yang jelas dan terfokus.
3) Explain the disadvantages of not applying SOLID principles to your project with examples.
    - butuh effort yang lebih untuk memahami kode secara keseluruhan dan biasanya hanya penulis kode tersebut yang paham benar maksud dari kodenya.
    - Kurang fleksibel karena perubahan suatu function dapat merubah program secara keseluruhan.
    - Lebih susah untuk testing dan mencari bug karena banyak kode digabungkan secara tidak terstruktur dan berantakan.

