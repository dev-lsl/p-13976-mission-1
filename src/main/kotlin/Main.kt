package com

import java.util.Scanner

object Main {
    private val scanner = Scanner(System.`in`)
    private val wiseSayingsList = mutableListOf<WiseSayings>()
    private var id = 0


    @JvmStatic
    fun main(args: Array<String>) {
        println("== 명언 ==")

        while (true) {
            print("명령) ")
            val cmd =scanner.nextLine().trim() // 삭제?id=1
            val baseCmd = if ("?" in cmd) cmd.split("?")[0] else cmd

            when (baseCmd) {
                "종료" -> return
                "등록" -> handleResister()
                "목록" -> handleList()
                "삭제" -> handleDelete(cmd)
                "수정" -> handleUpdate(cmd)
            }
        }
    }

    private fun handleResister() {
        print("명언 : ")
        var wiseSay:String = scanner.nextLine().trim()

        print("작가 : ")
        var author = scanner.nextLine().trim()
        id++

        wiseSayingsList.add(WiseSayings(id, wiseSay, author))
        println("$id 번 명언 등록 완료")
    }
}