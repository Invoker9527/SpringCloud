$(function () {
    //===��ʼ������===
    //����Ԫ��
    var $container = $("#content");
    var $wrapElement = $container.find(":first");
    var $slides = $wrapElement.children("li");
    var $boy = $("#boy");
    var $shop = $(".shop");
    var $door = $(".door");
    var $girl = $(".girl");
    var $a_bg_middle = $(".a_bg_middle");
    //������������ڵ��������ߴ�
    var windowWidth = $(window).width();
    var windowHeight = $(window).height();
    var sizeBase = windowWidth > windowHeight ? windowHeight : windowWidth;
    $container.css({
        "width": sizeBase * 0.8 + "px",
        "height": sizeBase * 0.5 + "px",
        "marginTop": -sizeBase * 0.5 / 2 + "px",
        "marginLeft": -sizeBase * 0.8 / 2 + "px"
    });
    //��ȡ�����ߴ�
    var width = $container.width();
    var height = $container.height();
    //����ul�ܿ��
    $wrapElement.css({
        width: ($slides.length * width) + "px",
        height: height + "px"
    });
    //����ÿһ��ҳ��li�Ŀ��
    $.each($slides, function (index) {
        //��ȡÿһ��liԪ��
        var $slide = $slides.eq(index);
        $slide.css({
            width: width + "px",
            height: height + "px"
        });
    });
    //����boyλ��
    //��ȡ·��Y��λ��
    var pathY = function () {
        var top = $a_bg_middle.position().top;
        var height = $a_bg_middle.height();
        return top + height / 2;
    }();
    //����boy��top����ֵ = �м�·�ε��м�����ֵ - С�к��ĸ߶� + ��Ӱ����ֵ
    var boyHeight = $boy.height();
    $boy.css({
        top: pathY - boyHeight + height * 0.0278
    });

    //����СŮ����λ��
    // ��topֵ
    var bridgeY = function () {
        return $(".c_bg_middle").position().top;
    }();
    $girl.css({
        left: width / 2,
        top: bridgeY - $girl.height()
    });

    //��boy��·��Ϊ��װΪһ������ķ���
    function BoyWalk($boy) {
        var boy = $boy;
        boy.walkTo = function (duration, percentageX, percentageY) {
            var defer = $.Deferred();
            $(this).addClass("slowWalk");
            var distX = width * percentageX;
            var distY = height * percentageY;
            $(this).animate({
                "left": distX + "px",
                "top": distY + "px"
            }, duration, function () {
                defer.resolve();
            });
            return defer;
        };
        boy.stopWalk = function () {
            var defer = $.Deferred();
            $(this).addClass("pauseWalk");
            defer.resolve();
            return defer;
        };
        boy.toShop = function (duration) {
            var defer = $.Deferred();
            boy.removeClass("pauseWalk");
            var top = $shop.position().top;
            var left = ($shop.position().left) + ($shop.width() / 2) - ($boy.width() / 2);
            $(this).animate({
                "left": left + "px",
                "top": top + "px",
                "opacity": 0
            }, duration, function () {
                defer.resolve();
            });
            return defer;
        };
        boy.takeFlower = function () {
            var defer = $.Deferred();
            //������ʱ�ȴ�Ч��
            setTimeout(function () {
                //ȡ��
                boy.addClass("takeFlowerWalk");
                defer.resolve();
            }, 1000);
            return defer;
        };
        boy.outShop = function (duration) {
            var defer = $.Deferred();
            $(this).animate({
                "top": pathY - boyHeight + height * 0.0278 + "px",
                "opacity": 1
            }, duration, function () {
                defer.resolve();
            });
            return defer;
        };
        boy.toBridge = function (duration) {
            var defer = $.Deferred();
            var distX = ($girl.position().left) - ($boy.width()) + width * 0.0243;//����ֵ
            var distY = $girl.position().top - height * 0.011;//����ֵ
            $(this).animate({
                "left": distX + "px",
                "top": distY + "px"
            }, 4000, function () {
                defer.resolve();
            });
            return defer;
        };
        boy.takeFlowerStop = function () {
            $(this).addClass("pauseWalk").addClass("boyTakeFlowerStop");
        };
        boy.turnAround = function () {
            $(this).addClass("boyTurnAround").removeClass("pauseWalk");
        };
        return boy;
    }

    var boy = BoyWalk($boy);

    //ҳ���л�����
    var page = {
        elem: $wrapElement,
        scrollTo: function (duration, pageCount) {
            var defer = $.Deferred();
            var distX = $container.width() * pageCount;
            this.elem.animate({
                "left": "-" + distX + "px"
            }, duration, function () {
                defer.resolve();
            });
            return defer;
        }
    };
    /*��һ��ҳ��*/

    //��Ʈ������
    function cloudAnimate() {
        var $cloud1 = $("#cloud1");
        var $cloud2 = $("#cloud2");
        $cloud1.addClass("cloud1-animation");
        $cloud2.addClass("cloud2-animation");
    }

    //̫����ɽ����
    function sunRotate() {
        var $sun = $("#sun");
        $sun.addClass("sunRotation");
    }

    /*�ڶ���ҳ��*/

    //�Ŷ�������
    function doorAction(left, right, time) {
        var defer = $.Deferred();
        var doorLeft = $(".door_left");
        var doorRight = $(".door_right");
        var count = 2;
        // �ȴ��������
        var complete = function () {
            if (count == 1) {
                defer.resolve();
                return;
            }
            count--;
        };
        doorLeft.animate({
            "left": left
        }, time, complete);
        doorRight.animate({
            "left": right
        }, time, complete);
        return defer;
    }

    // ����
    function openDoor() {
        return doorAction("-50%", "100%", 2000);
    }

    // ����
    function shutDoor() {
        return doorAction("0%", "50%", 2000);
    }

    //�ƶ���
    var lamp = {
        elem: $(".lamp"),
        bright: function () {
            var defer = $.Deferred();
            this.elem.addClass("lamp_bright");
            defer.resolve();
        },
        dark: function () {
            this.elem.removeClass("lamp_bright");
        }
    };
    //���񶯻�
    var bird = {
        elem: $(".bird"),
        fly: function () {
            this.elem.addClass("birdFly");
            this.elem.animate({
                right: $container.width()
            }, 15000);
        }
    };

    /*������ҳ��*/
    //СŮ����������
    var girl = {
        elem: $girl,
        turnAround: function () {
            this.elem.addClass("girlTurnAround");
        }
    };

    //����ת����
    function turnAround() {
        var defer = $.Deferred();
        setTimeout(function () {
            girl.turnAround();
            boy.turnAround();
            defer.resolve();
        }, 1000);
        return defer;
    }

    //������������
    function starTwinkle() {
        var $stars = $(".stars > li");
        var len = $stars.length;
        var i = 0;
        var timer = setInterval(function () {
            $($stars[i]).addClass("starTwinkle");
            if (i < len) {
                i++;
            } else {
                clearInterval(timer);
            }
        }, 1000);

    }

    //ˮ��������
    function waterWave() {
        var $waters = $(".waters > li");
        var len = $waters.length;
        var i = 0;
        var timer = setInterval(function () {
            $($waters[i]).addClass("waterWave");
            if (i < len) {
                i++;
            } else {
                clearInterval(timer);
            }
        }, 1000);

    }

    //���6�ֻ���ͼƬλ�ðٷֱ�
    var flowersPos = ["0", "20%", "40%", "60%", "80", "100%"];
    // ��ȡ��������
    var $flowerContainer = $("#flower_wrap");
    var flowerUrl = "images/flower.png";

    //����Ʈ�䶯������
    function flowerDrop() {
        // �����ȡ����ͼƬurl
        function getFlowerPos() {
            return flowersPos[Math.floor(Math.random() * 6)];
        }

        //������ӿ��
        var flowerBoxWidth = width * 0.0285;
        var flowerBoxHeight = height * 0.0456;

        // ����һ������Ԫ�أ������ת��
        function createFlowerBox() {
            var pos = getFlowerPos();
            return $('<div class="flowerBox"></div>').css({
                "width": flowerBoxWidth + "px",
                "height": flowerBoxHeight + "px",
                "position": "absolute",
                "zIndex": 1000,
                "top": -flowerBoxHeight + "px",
                "backgroundImage": "url(" + flowerUrl + ")",
                "backgroundRepeat": "no-repeat",
                "backgroundSize": "600% 100%",
                "backgroundPosition": pos + " 0"
            }).addClass("flowerRotate");
        }

        // ��ʼƮ��
        setInterval(function () {
            // �˶��켣���
            var startPositionLeft = Math.random() * width - 100,
                startOpacity = 1,
                endPositionTop = height - 40,
                endPositionLeft = startPositionLeft - 100 + Math.random() * 500,
                duration = height * 10 + Math.random() * 5000;

            // ���͸���ȣ���С��0.5
            var randomStart = Math.random();
            randomStart = randomStart < 0.5 ? startOpacity : randomStart;

            // ����һ������
            var $flower = createFlowerBox();
            // ������λ��
            $flower.css({
                left: startPositionLeft + "px",
                opacity: randomStart
            });
            // ���뵽����
            $flowerContainer.append($flower);
            // ��ʼִ�ж���
            $flower.animate({
                top: endPositionTop + "px",
                left: endPositionLeft + "px",
                opacity: 0.7
            }, duration, function () {
                $(this).animate({
                    opacity: 0
                }, 1000, function () {
                    $(this).remove(); //������ɾ��
                });
            });

        }, 300);
    }

    // ��������
    var audioConfig = {
        enable: true, // �Ƿ�������
        playURl: "music/happy.wav", // �������ŵ�ַ
        cycleURL: "music/circulation.wav" // ����ѭ�����ŵ�ַ
    };

    //�������ֲ���
    function Html5Audio(url, isloop) {
        var audio = new Audio(url);
        audio.autoPlay = true;
        audio.loop = isloop || false;
        audio.play();
        return {
            end: function (callback) {
                audio.addEventListener("ended", function () {
                    callback();
                }, false);
            }
        };
    }

    //ҳ�涯��
    function pageAStartRun() {
        //��������
        var audio1 = Html5Audio(audioConfig.playURl);
        audio1.end(function () {
            Html5Audio(audioConfig.cycleURL, true);
        })
        //��Ʈ��
        cloudAnimate();
        //̫����ɽ
        sunRotate();
        boy.walkTo(4000, 0.5)
            .then(function () {
                return page.scrollTo(9000, 1);
            }).then(function () {
            bird.fly();
            return boy.stopWalk();
        }).then(function () {
            return openDoor();
        }).then(function () {
            return lamp.bright();
        }).then(function () {
            return boy.toShop(2000);
        }).then(function () {
            return boy.takeFlower();
        }).then(function () {
            return boy.outShop(2000);
        }).then(function () {
            lamp.dark();
            shutDoor();
            page.scrollTo(9000, 2);
        }).then(function () {
            return boy.walkTo(9000, 0.15);
        }).then(function () {
            starTwinkle();
            waterWave();
            return boy.toBridge(4000);
        }).then(function () {
            boy.takeFlowerStop();
            return turnAround();
        }).then(function () {
            flowerDrop();
        });
    }

    $("button").click(function () {
        $(this).animate({
            "opacity": 0
        }, 1000);
        pageAStartRun();
    });
});
