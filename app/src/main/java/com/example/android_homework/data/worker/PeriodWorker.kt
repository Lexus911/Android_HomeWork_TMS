package com.example.android_homework.data.worker


import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.android_homework.data.auth.AuthRepositoryImpl
import com.example.android_homework.presentation.model.UsersModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@HiltWorker
class PeriodWorker @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted parameters: WorkerParameters,
    val authRepositoryImpl: AuthRepositoryImpl
) : CoroutineWorker(context, parameters){

    override suspend fun doWork(): Result {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                Log.w("doWork called", "getData")
//                authRepositoryImpl.registerUser(UsersModel(null, "Max","BigMac","" +
//                        "abc@gmail.com","password"))
            }
        }catch (e: Exception){
            Log.w("doWork failed", e.toString())
            return Result.retry()
        }
        return Result.success()
    }

    companion object {
        const val WORKER_NAME = "Worker Name"
    }
}
