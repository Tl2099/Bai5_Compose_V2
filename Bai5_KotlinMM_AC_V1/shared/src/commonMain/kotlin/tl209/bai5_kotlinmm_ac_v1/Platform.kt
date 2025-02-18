package tl209.bai5_kotlinmm_ac_v1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform