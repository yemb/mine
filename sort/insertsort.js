// 插入排序
// 时间复杂度  O(n2) O(n2) O(n)
// 空间复杂度   O（1）稳定
var arr = [1,80,9,13,57,254,23,34,4,30]

function insert(arr) {
    var len = arr.length;
    for(let i = 1;i<len;i++) {
        // for(let j = 0;j<i;j++) {
        //     if(arr[i]<arr[j]) {
        //         arr[j+1] = arr[j]
        //         arr[j] = arr[i]
        //     }
        // }
        var j = i-1
        var temp = arr[i]
        while(j>=0&&arr[j]>temp) {
            arr[j+1] = arr[j--]
        }
        arr[j+1] = temp
    }
    return arr
}

console.log(insert(arr))