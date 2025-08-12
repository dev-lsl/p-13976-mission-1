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

    private fun handleList() {
        println("번호 /  작가 / 명언")

        for (w in wiseSayingsList) {
            println("${w.id} / ${w.author} / ${w.wiseSay}")
        }

    }
    // 삭제?id=1
    private fun handleDelete(cmd: String) {
        val idToDelete = cmd.substring("삭제?id=".length).toIntOrNull() // id 추출

        var found = false

        for (w in wiseSayingsList) {
            if (w.id == idToDelete) {
                wiseSayingsList.remove(w)
                println("$idToDelete 번 명언 삭제 완료")
                found = true
                break
            }
        }
        if (!found) {
            println("$idToDelete 번 명언은 존재하지 않습니다.")
        }

    }

    private fun handleUpdate(cmd: String) {
        val idToUpdate = cmd.substring("수정?id=".length).toIntOrNull() // id 추출

        var found = false

        for (w in wiseSayingsList){
            if (w.id== idToUpdate) {

                println("명언(기존) : ${w.wiseSay}")
                print("명언 : ")
                w.wiseSay = scanner.nextLine().trim()

                println("작가(기존) : ${w.author}")
                print("작가 : ")
                w.author = scanner.nextLine().trim()

                println("$idToUpdate 번 명언 수정 완료")
                found = true
                break
            }
        }
    }
}