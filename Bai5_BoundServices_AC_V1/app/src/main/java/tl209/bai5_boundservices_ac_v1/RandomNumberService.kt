package tl209.bai5_boundservices_ac_v1

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import kotlin.random.Random

//Dinh nghia lop People
data class People(val name: String, val age: Int)

//Tao Bound Service
class RandomNumberService: Service(){
    private val binder = LocalBinder()

    inner class LocalBinder: Binder() {
        fun getService(): RandomNumberService = this@RandomNumberService
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    //Phuong thuc tra ve so ngau nhien
    fun getRandomNumber(): Int{
        return Random.nextInt(1,100)
    }

    //Phuong thuc tra ve mot chuoi van ban
    fun getText(): String{
        return "Hello World"
    }

    //Phuong thuc tra ve mot so nguyen
    fun getInt(): Int{
        return 69
    }

    //Phuong thuc tra ve mot danh sach doi tuong People
    fun getArray(): List<People>{
        return listOf(
            People("Alice", 25),
            People("Bob", 30),
            People("Charlie", 35),
        )
    }
}