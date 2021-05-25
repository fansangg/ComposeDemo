package com.example.compose.helper

import com.blankj.utilcode.util.GsonUtils
import com.example.compose.bean.UserInfo

object DataFactory {

    fun createUserData(): List<UserInfo> {

        val json = """
                [
                    {
                        "arteId":"iiDr515517946",
                        "createTime":1621309712576,
                        "esModifyTime":1621309714741,
                        "followStatus":false,
                        "id":"156085175_iiDr515517946",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "nickName":"JtnlFB155pOH",
                        "pos":"39.975880,116.484126",
                        "sort":"1621309712576,1269086110680317953",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/user/fictitious/1589018233234.png",
                        "userId":156085175,
                        "userNo":"lYkD2542732"
                    },
                    {
                        "arteId":"Ilwkx15517945",
                        "createTime":1621309102627,
                        "esModifyTime":1621309104773,
                        "followStatus":false,
                        "id":"156084611_Ilwkx15517945",
                        "isLikeArte":0,
                        "isPro":1,
                        "kind":1,
                        "location":"",
                        "nickName":"女新疆",
                        "pos":"39.975682,116.484094",
                        "sort":"1621309102627,1269052025819840515",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/avatar/156084611/e4a1fbf2e10bbb96a9567c4dbf04d8b5.jpg",
                        "userId":156084611,
                        "userNo":"NvXJ123"
                    },
                    {
                        "arteId":"OULsa15517943",
                        "createTime":1621306859192,
                        "esModifyTime":1621306859759,
                        "followStatus":false,
                        "id":"156084902_OULsa15517943",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "nickName":"测试45",
                        "pos":"39.975850,116.484151",
                        "sort":"1621306859192,1266873858925445320",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/user/fictitious/1614669986745.jpg?imageInfo=540_540",
                        "userId":156084902,
                        "userNo":"ceshi45"
                    },
                    {
                        "arteId":"a2Ml515517942",
                        "createTime":1621306832505,
                        "esModifyTime":1621306833120,
                        "followStatus":false,
                        "id":"156084903_a2Ml515517942",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "nickName":"测试46",
                        "pos":"39.975902,116.484137",
                        "sort":"1621306832505,1266873858925445318",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/user/fictitious/1614670005977.jpg?imageInfo=540_540",
                        "userId":156084903,
                        "userNo":"ceshi46"
                    },
                    {
                        "arteId":"bPLi215517940",
                        "createTime":1621306530438,
                        "esModifyTime":1621306530989,
                        "followStatus":false,
                        "id":"156084576_bPLi215517940",
                        "isLikeArte":0,
                        "isPro":1,
                        "kind":1,
                        "nickName":"泰斯特01",
                        "pos":"39.975869,116.484217",
                        "sort":"1621306530438,1266873858925445289",
                        "top":0,
                        "userIcon":"https://arte.oss-cn-beijing.aliyuncs.com/avatar/156084576/7B04AD13-DC1B-4927-AE05-81146DC81A6F.jpg",
                        "userId":156084576,
                        "userNo":"W2Wj2541846"
                    },
                    {
                        "arteId":"apQ4o15517938",
                        "createTime":1621305524443,
                        "esModifyTime":1621305525174,
                        "followStatus":false,
                        "id":"156085143_apQ4o15517938",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "nickName":"溜溜",
                        "pos":"39.975884,116.484114",
                        "sort":"1621305524443,1266873858925445240",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/avatar/156085143/8b371d77a2096aaf8d8becf31e64e645.jpg",
                        "userId":156085143,
                        "userNo":"AHLk2542699"
                    },
                    {
                        "arteId":"zmPLV15517935",
                        "createTime":1621304582989,
                        "esModifyTime":1621304583528,
                        "followStatus":false,
                        "id":"156084619_zmPLV15517935",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "nickName":"女甘肃22",
                        "pos":"39.975883,116.484199",
                        "sort":"1621304582989,1266873858925445211",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/user/fictitious/1603336754106.jpg?imageInfo=400_400",
                        "userId":156084619,
                        "userNo":"NVGS22"
                    },
                    {
                        "arteId":"T16SP15517934",
                        "createTime":1621250007901,
                        "esModifyTime":1621250008498,
                        "followStatus":false,
                        "id":"156084790_T16SP15517934",
                        "isLikeArte":0,
                        "isPro":1,
                        "kind":1,
                        "nickName":"金角大王",
                        "pos":"39.975870,116.484094",
                        "sort":"1621250007901,1266873858925445206",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/avatar/156084790/9571341A-2A82-4DFB-85A1-E210E09D2371.jpg",
                        "userId":156084790,
                        "userNo":"Abcdefghifklimn"
                    },
                    {
                        "arteId":"k8JST15517933",
                        "createTime":1621249911271,
                        "esModifyTime":1621249911804,
                        "followStatus":false,
                        "id":"156085178_k8JST15517933",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "nickName":"kdjhSBIYLJzw",
                        "pos":"39.975877,116.484043",
                        "sort":"1621249911271,1266873858925445204",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/user/fictitious/1589018233234.png",
                        "userId":156085178,
                        "userNo":"GA9c2542735"
                    },
                    {
                        "arteId":"9keL115517932",
                        "createTime":1621249353455,
                        "esModifyTime":1621249354083,
                        "followStatus":false,
                        "id":"156085177_9keL115517932",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "nickName":"c5kG1a7SXP2J",
                        "pos":"39.975852,116.484021",
                        "sort":"1621249353455,1266873858925445201",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/user/fictitious/1589018233234.png",
                        "userId":156085177,
                        "userNo":"7BWm2542734"
                    },
                    {
                        "arteId":"6b8xC15517930",
                        "createTime":1621247450429,
                        "esModifyTime":1621247451037,
                        "followStatus":false,
                        "id":"156084620_6b8xC15517930",
                        "isLikeArte":0,
                        "isPro":3,
                        "kind":1,
                        "nickName":"男内蒙古10",
                        "pos":"39.975824,116.484119",
                        "sort":"1621247450429,1266873858925445194",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/user/fictitious/1603338631241.jpg?imageInfo=690_690",
                        "userId":156084620,
                        "userNo":"NANNMG10"
                    },
                    {
                        "arteId":"3uzJ415517928",
                        "createTime":1621247316485,
                        "esModifyTime":1621247317119,
                        "followStatus":false,
                        "id":"156084621_3uzJ415517928",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "nickName":"女内蒙古28",
                        "pos":"39.975824,116.484119",
                        "sort":"1621247316485,1266873858925445187",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/user/fictitious/1603347200978.jpg?imageInfo=400_400",
                        "userId":156084621,
                        "userNo":"NVNMG28"
                    },
                    {
                        "arteId":"3eIjq15517926",
                        "createTime":1621246880285,
                        "esModifyTime":1621246881000,
                        "followStatus":false,
                        "id":"156084622_3eIjq15517926",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "nickName":"女沈阳36",
                        "pos":"39.975278,116.483676",
                        "sort":"1621246880285,1266873858925445181",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/user/fictitious/1603349783843.jpg?imageInfo=672_672",
                        "userId":156084622,
                        "userNo":"NVSY36"
                    },
                    {
                        "arteId":"H4rJU15517924",
                        "createTime":1621246819404,
                        "esModifyTime":1621246820058,
                        "followStatus":false,
                        "id":"156084623_H4rJU15517924",
                        "isLikeArte":0,
                        "isPro":1,
                        "kind":1,
                        "nickName":"这是我的名字",
                        "pos":"39.975250,116.483652",
                        "sort":"1621246819404,1266873858925445175",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/user/fictitious/1603349930811.jpg?imageInfo=1000_1000",
                        "userId":156084623,
                        "userNo":"NANHEB21"
                    },
                    {
                        "arteId":"grREN15517922",
                        "createTime":1621246762031,
                        "esModifyTime":1621246762568,
                        "followStatus":false,
                        "id":"156085078_grREN15517922",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "nickName":"KZR0TH2T9d6p",
                        "pos":"39.975888,116.484153",
                        "sort":"1621246762031,1266873858925445166",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/user/fictitious/1589018233234.png",
                        "userId":156085078,
                        "userNo":"ncO32542623"
                    },
                    {
                        "arteId":"AfLVF15517920",
                        "createTime":1621246636988,
                        "esModifyTime":1621246637588,
                        "followStatus":false,
                        "id":"156084950_AfLVF15517920",
                        "isLikeArte":0,
                        "isPro":1,
                        "kind":1,
                        "nickName":"AND呼呼",
                        "pos":"39.975875,116.484178",
                        "sort":"1621246636988,1266873858925445154",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/user/fictitious/1617954071139.jpg?imageInfo=864_864",
                        "userId":156084950,
                        "userNo":"mHiZ2542464"
                    },
                    {
                        "arteId":"nULzT15517905",
                        "createTime":1621241829992,
                        "esModifyTime":1621241830575,
                        "followStatus":false,
                        "id":"156085176_nULzT15517905",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "nickName":"C2SriOeKqAL2",
                        "pos":"39.975866,116.484137",
                        "sort":"1621241829992,1266722607357067300",
                        "top":0,
                        "userIcon":"https://arte.oss-cn-beijing.aliyuncs.com/user/fictitious/1589018233234.png",
                        "userId":156085176,
                        "userNo":"8lPS2542733"
                    },
                    {
                        "arteId":"Fkqmr15517895",
                        "createTime":1621239837666,
                        "esModifyTime":1621239838201,
                        "followStatus":false,
                        "id":"156084626_Fkqmr15517895",
                        "isLikeArte":0,
                        "isPro":1,
                        "kind":1,
                        "nickName":"酸奶士多",
                        "pos":"39.975885,116.484149",
                        "sort":"1621239837666,1266672167261126668",
                        "top":0,
                        "userIcon":"https://arte.oss-cn-beijing.aliyuncs.com/avatar/156084626/AAD7EC79-29C3-4C92-88F6-3A844770CABC.jpg",
                        "userId":156084626,
                        "userNo":"r7tK2541896"
                    },
                    {
                        "arteId":"cth2A15517887",
                        "createTime":1621235237692,
                        "esModifyTime":1621235238322,
                        "followStatus":false,
                        "id":"156085053_cth2A15517887",
                        "isLikeArte":0,
                        "isPro":1,
                        "kind":1,
                        "nickName":"亮名毁",
                        "pos":"39.975888,116.484172",
                        "sort":"1621235237692,1258000559570993497",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/avatar/156085053/23A29FF2-C419-4BEB-9253-ED97F10F9A6C.jpg",
                        "userId":156085053,
                        "userNo":"NQjD2542590"
                    },
                    {
                        "arteId":"zO0oT15517883",
                        "createTime":1621234244641,
                        "esModifyTime":1621234245257,
                        "followStatus":false,
                        "id":"156084677_zO0oT15517883",
                        "isLikeArte":0,
                        "isPro":3,
                        "kind":1,
                        "nickName":"超rain",
                        "pos":"39.975878,116.484143",
                        "sort":"1621234244641,1258000559570993476",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/avatar/156084677/925B1A9C-B00B-4EFA-86B4-92E5DE97FA30.jpg",
                        "userId":156084677,
                        "userNo":"CHAORAIN"
                    },
                    {
                        "arteId":"7ObeQ15517882",
                        "createTime":1621234238272,
                        "esModifyTime":1621234238774,
                        "followStatus":false,
                        "id":"156084685_7ObeQ15517882",
                        "isLikeArte":0,
                        "isPro":1,
                        "kind":1,
                        "nickName":"你瞅啥",
                        "pos":"39.975907,116.484090",
                        "sort":"1621234238272,1258000559570993473",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/avatar/156084685/502FD4F7-E2FB-480E-9CFA-2FCB492B24AF.jpg",
                        "userId":156084685,
                        "userNo":"Lueluelue"
                    },
                    {
                        "arteId":"XgXQ515517881",
                        "createTime":1621234212424,
                        "esModifyTime":1621234212968,
                        "followStatus":false,
                        "id":"156085169_XgXQ515517881",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "nickName":"b0XHttmBr5pq",
                        "pos":"39.975881,116.484158",
                        "sort":"1621234212424,1258000559570993470",
                        "top":0,
                        "userIcon":"https://arte.oss-cn-beijing.aliyuncs.com/user/fictitious/1589018233234.png",
                        "userId":156085169,
                        "userNo":"ETMi2542726"
                    },
                    {
                        "arteId":"bzCmn15517880",
                        "createTime":1621234208560,
                        "esModifyTime":1621234209058,
                        "followStatus":false,
                        "id":"156085148_bzCmn15517880",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "nickName":"vae",
                        "pos":"39.975864,116.484158",
                        "sort":"1621234208560,1258000559570993468",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/avatar/156085148/63D41B86-7325-4D1A-B656-E3BEDEB42416.jpg",
                        "userId":156085148,
                        "userNo":"iRTb2542704"
                    },
                    {
                        "arteId":"peKvA15517879",
                        "createTime":1621234127922,
                        "esModifyTime":1621234128672,
                        "followStatus":false,
                        "id":"156085168_peKvA15517879",
                        "isLikeArte":0,
                        "isPro":2,
                        "kind":1,
                        "nickName":"蟹老板家的蟹黄堡最好吃",
                        "pos":"39.975846,116.484087",
                        "sort":"1621234127922,1258000559570993465",
                        "top":0,
                        "userIcon":"https://oss.sceneconsole.cn/avatar/156085168/C322C661-C22B-43F7-913B-2ABE8D9C42D5.jpg",
                        "userId":156085168,
                        "userNo":"qiQE2542725"
                    },
                    {
                        "arteId":"7oElj15517865",
                        "createTime":1621219422001,
                        "esModifyTime":1621219423070,
                        "followStatus":false,
                        "id":"156085170_7oElj15517865",
                        "isLikeArte":0,
                        "isPro":0,
                        "kind":1,
                        "location":"",
                        "nickName":"香水菠萝",
                        "pos":"39.975682,116.484097",
                        "sort":"1621219422001,1258000559570993406",
                        "top":0,
                        "userIcon":"https://arte.oss-cn-beijing.aliyuncs.com/avatar/null/bfa4aa647b2155e3f920d33603595a85.jpg",
                        "userId":156085170,
                        "userNo":"HZQP2542727"
                    }
                ]
            """.trimIndent()
        return GsonUtils.fromJson(
            json, GsonUtils.getListType(UserInfo::class.java)
        )
    }
}