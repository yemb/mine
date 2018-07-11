//选择排序
// 时间复杂度  O(n2) O(n2) O(n2)
// 空间复杂度   O（1） 稳定


var arr = [1,80,9,13,57,254,23,34,3,30]

function select(arr) {
    var len = arr.length;
    for(let i = 0;i<len-1;i++) {
        var min = i;
        for(let j = i+1;j<len;j++){
            if(arr[j]<arr[min])
                min = j
        }
        if(i!=min)
            [arr[min],arr[i]] = [arr[i],arr[min]]
    }
    return arr
}
console.log(select(arr))